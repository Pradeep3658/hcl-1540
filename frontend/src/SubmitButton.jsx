import { useFormStatus } from "react-dom";

const SubmitButton = ({ label = "Submit" }) => {
  const { pending } = useFormStatus();

  return (
    <button className="primary-button" type="submit" disabled={pending}>
      {pending ? "Please wait..." : label}
    </button>
  );
};

export default SubmitButton;