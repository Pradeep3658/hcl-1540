import './App.css';
import Dashboard from './Dashboard.jsx';
import Home from './Home.jsx';
import Login from './login.jsx';
import Registration from './Registration.jsx';
import SampleCode from './SampleCode.jsx';

import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Registration />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/sample" element={<SampleCode />} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;