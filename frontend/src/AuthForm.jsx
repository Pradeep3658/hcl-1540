import api from "./api";
import SubmitButton from "./SubmitButton";
import { useState, useActionState } from "react";

const AuthForm = ({ onLogin }) => {
  const [mode, setMode] = useState("login");

  const submitAction = async (prevState, formData) => {
    const username = formData.get("username")?.trim();
    const password = formData.get("password")?.trim();

    if (!username || !password) {
      return { error: "Enter your username and password.", msg: "", username: username || "" };
    }

    try {
      if (mode === "register") {
        await api.post("/auth/register", { username, password });
        setMode("login");
        return { error: null, msg: "Account created. You can log in now.", username };
      }

      const { data } = await api.post("/auth/login", { username, password });
      if (!data.token || data.token === "error") {
        return { error: data.username || "Username or password is incorrect.", msg: "", username };
      }
      localStorage.setItem("token", data.token);
      localStorage.setItem("username", username);
      onLogin(username);
      return { error: null, msg: "", username: data.username };
    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.data?.message ||
          error.response?.data?.username ||
          "Something went wrong. Please try again.",
        msg: "",
        username,
      };
    }
  };

  const [state, formAction, isPending] = useActionState(submitAction, {
    error: null,
    msg: "",
    username: "",
  });

  return (
    <form className="form-card auth-card" action={formAction}>
      <p className="eyebrow">WELCOME</p>
      <h2>{mode === "login" ? "Good to see you" : "Join the blog"}</h2>
      <p className="form-intro">
        {mode === "login" ? "Log in to share a post with everyone." : "Create an account to start writing."}
      </p>
      <label htmlFor="username">Username</label>
      <input
        type="text"
        name="username"
        id="username"
        placeholder="Your username"
        autoComplete="username"
        defaultValue={state.username}
        required
        disabled={isPending}
      />
      <label htmlFor="password">Password</label>
      <input
        type="password"
        name="password"
        id="password"
        placeholder="Your password"
        autoComplete={mode === "login" ? "current-password" : "new-password"}
        required
        disabled={isPending}
      />
      <SubmitButton label={mode === "login" ? "Log in" : "Create account"} />
      <button
        className="switch-button"
        type="button"
        disabled={isPending}
        onClick={() => setMode(mode === "login" ? "register" : "login")}
      >
        {mode === "login" ? "New here? Create an account" : "Already have an account? Log in"}
      </button>
      {state.msg && <p className="form-message success" role="status">{state.msg}</p>}
      {state.error && <p className="form-message error" role="alert">{state.error}</p>}
    </form>
  );
};

export default AuthForm;