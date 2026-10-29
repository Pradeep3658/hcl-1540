function Home() {
    return (
        <div className="container mt-5">
            <h1 className="text-center">Attendance Management System</h1>

            <div className="card mt-4">
                <div className="card-body text-center">
                    <h3>Welcome!</h3>
                    <p>
                        Manage employee attendance easily with our system.
                    </p>

                    <button className="btn btn-primary">
                        View Attendance
                    </button>
                </div>
            </div>
        </div>
    );
}

export default Home;