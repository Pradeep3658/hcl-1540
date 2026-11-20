
import { useState } from 'react';

function SampleCode() {
  const [employee, setEmployee] = useState({
    id: '23456',
    name: '',
    email: '',
    designation: '',
    techStack: '',
    password: '',
    terms: false,
  });

  function handleChange(e) {
    const { name, value, type, checked } = e.target;

    setEmployee({
      ...employee,
      [name]: type === 'checkbox' ? checked : value,
    });
  }

  function handleSubmit(e) {
    e.preventDefault();
    alert('Employee registered successfully!');
    console.log(employee);
  }

  return (
    <div className="form-container">
      <h2>Employee Registration</h2>

      <form onSubmit={handleSubmit}>
        <label>Employee ID</label>
        <input
          type="number"
          name="id"
          value={employee.id}
          onChange={handleChange}
          required
        />

        <label>Name</label>
        <input
          type="text"
          name="name"
          placeholder="Enter name"
          value={employee.name}
          onChange={handleChange}
          required
        />

        <label>Email</label>
        <input
          type="email"
          name="email"
          placeholder="Enter email"
          value={employee.email}
          onChange={handleChange}
          required
        />

        <label>Designation</label>
        <input
          type="text"
          name="designation"
          placeholder="Enter designation"
          value={employee.designation}
          onChange={handleChange}
          required
        />

        <label>Tech-Stack</label>
        <input
          type="text"
          name="techStack"
          placeholder="Enter techstack"
          value={employee.techStack}
          onChange={handleChange}
          required
        />

        <label>Password</label>
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={employee.password}
          onChange={handleChange}
          required
        />

        <div className="checkbox-container">
          <input
            type="checkbox"
            name="terms"
            checked={employee.terms}
            onChange={handleChange}
            required
          />
          <span>Check me out</span>
        </div>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default SampleCode;
