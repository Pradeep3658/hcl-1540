import { useState, useEffect } from 'react';

function useFetchApi(url) {
    const [data, setData] = useState(null);
    const [error, setError] = useState('');

    useEffect(() => {
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error('HTTP Error: ' + response.status);
                }
                return response.json();
            })
            .then(result => {
                setData(result);
            })
            .catch(err => {
                setError(err.message);
            });
    }, [url]);

    return { data, error };
}

export default useFetchApi;