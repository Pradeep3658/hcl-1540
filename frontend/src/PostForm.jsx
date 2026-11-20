import { useActionState } from "react";
import SubmitButton from "./SubmitButton";
import api from "./api";

const PostForm = ({ onCreated }) => {
  const submitAction = async (prev, formData) => {
    const title = formData.get("title")?.trim();
    const content = formData.get("content")?.trim();
    if (!title || !content) {
      return {
        error: "Please add both a title and some content.",
        msg: "",
        title: title || "",
        content: content || "",
      };
    }
    try {
      await api.post("/posts", { title, content });
      await onCreated?.();
      return { error: null, msg: "Your post is published.", title: "", content: "" };
    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.data?.message ||
          "Could not publish your post. Please try again.",
        msg: "",
        title,
        content,
      };
    }
  };

  const [state, formAction, isPending] = useActionState(submitAction, {
    error: null,
    msg: "",
    title: "",
    content: "",
  });

  return (
    <form className="form-card" action={formAction}>
      <p className="eyebrow">YOUR SPACE</p>
      <h2>Write a post</h2>
      <p className="form-intro">Got something on your mind? Put it into words.</p>
      <label htmlFor="title">Title</label>
      <input
        type="text"
        name="title"
        id="title"
        placeholder="Give your post a title"
        defaultValue={state.title}
        maxLength={200}
        required
        disabled={isPending}
      />
      <label htmlFor="content">Your thoughts</label>
      <textarea
        name="content"
        id="content"
        placeholder="Start writing here..."
        rows={6}
        defaultValue={state.content}
        required
        disabled={isPending}
      />
      <SubmitButton label="Publish post" />
      {state.msg && <p className="form-message success" role="status">{state.msg}</p>}
      {state.error && <p className="form-message error" role="alert">{state.error}</p>}
    </form>
  );
};

export default PostForm;