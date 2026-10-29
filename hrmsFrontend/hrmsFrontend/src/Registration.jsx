
import { useState } from 'react';

const API_URL = 'http://localhost:8080/v1/user/register';

const initialForm = {
  name: '',
  email: '',
  designation: '',
  techStack: '',
  password: '',
  terms: false,
};

function Registration() {
  const [form, setForm] = useState(initialForm);
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [message, setMessage] = useState({ type: '', text: '' });

  function handleChange(event) {
    const { name, value, type, checked } = event.target;

    setForm((current) => ({
      ...current,
      [name]: type === 'checkbox' ? checked : value,
    }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setMessage({ type: '', text: '' });

    if (!form.terms) {
      setMessage({
        type: 'danger',
        text: 'Please accept the terms before submitting.',
      });
      return;
    }

    setIsSubmitting(true);

    try {
      const response = await fetch(API_URL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          name: form.name.trim(),
          email: form.email.trim(),
          designation: form.designation.trim(),
          stack: form.techStack.trim(),
          password: form.password,
        }),
      });

      const data = await response.json().catch(() => null);

      if (!response.ok) {
        const errorMessage =
          data?.message ||
          (typeof data === 'string' ? data : null) ||
          `Request failed with status ${response.status}`;

        throw new Error(errorMessage);
      }

      setForm(initialForm);

      setMessage({
        type: 'success',
        text: `Employee registered successfully. Employee ID: ${
          data?.id ?? 'Created by server'
        }`,
      });
    } catch (error) {
      setMessage({
        type: 'danger',
        text:
          error instanceof TypeError
            ? 'Unable to connect to the backend. Check whether Spring Boot is running and CORS is configured.'
            : error.message,
      });
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <div className="container mt-4" style={{ maxWidth: '640px' }}>
      <h2 className="mb-4">Employee Registration</h2>

      {message.text && (
        <div className={`alert alert-${message.type}`} role="alert">
          {message.text}
        </div>
      )}

      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label" htmlFor="employeeId">
            Employee ID
          </label>
          <input
            className="form-control"
            id="employeeId"
            value="Assigned by the server"
            disabled
          />
          <div className="form-text">
            The database generates the employee ID when registration succeeds.
          </div>
        </div>

        <div className="mb-3">
          <label className="form-label" htmlFor="employeeName">
            Name
          </label>
          <input
            className="form-control"
            id="employeeName"
            name="name"
            value={form.name}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label" htmlFor="employeeEmail">
            Email
          </label>
          <input
            className="form-control"
            id="employeeEmail"
            name="email"
            type="email"
            value={form.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label" htmlFor="designation">
            Designation
          </label>
          <input
            className="form-control"
            id="designation"
            name="designation"
            value={form.designation}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label" htmlFor="techStack">
            Tech-Stack
          </label>
          <input
            className="form-control"
            id="techStack"
            name="techStack"
            value={form.techStack}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label" htmlFor="password">
            Password
          </label>
          <input
            className="form-control"
            id="password"
            name="password"
            type="password"
            value={form.password}
            onChange={handleChange}
            required
            minLength={8}
          />
          <div className="form-text">
            Configure secure password hashing before using this form for real accounts.
          </div>
        </div>

        <div className="form-check mb-3">
          <input
            className="form-check-input"
            id="terms"
            name="terms"
            type="checkbox"
            checked={form.terms}
            onChange={handleChange}
            required
          />
          <label className="form-check-label" htmlFor="terms">
            I agree to the terms.
          </label>
        </div>

        <button
          className="btn btn-primary"
          type="submit"
          disabled={isSubmitting}
        >
          {isSubmitting ? 'Submitting...' : 'Submit'}
        </button>
      </form>
    </div>
  );
}

export default Registration;