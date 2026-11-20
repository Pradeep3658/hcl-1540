import { useEffect, useState } from "react";
import api from "./api";
import AuthForm from "./AuthForm";
import PostForm from "./PostForm";

const App = () => {
  const [user, setUser] = useState(localStorage.getItem("username"));
  const [posts, setPosts] = useState([]);

  const loadPosts = async () => {
    const { data } = await api.get("/posts");
    setPosts(data);
  };

  useEffect(() => {
    const handleAuthExpired = () => setUser(null);
    window.addEventListener("auth-expired", handleAuthExpired);
    loadPosts().catch(() => {});
    return () => window.removeEventListener("auth-expired", handleAuthExpired);
  }, []);

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    setUser(null);
  };

  return (
    <div className="site-shell">
      <header className="site-header">
        <a className="brand" href="/" aria-label="JWT Blog home">
          <span className="brand-mark">J</span>
          <span>little blog</span>
        </a>
        <div className="header-account">
          {user ? (
            <>
              <span className="signed-in">Hi, {user}</span>
              <button className="text-button" onClick={logout}>Log out</button>
            </>
          ) : (
            <span className="header-note">A small place for your thoughts</span>
          )}
        </div>
      </header>

      <main className="page-content">
        <section className="intro">
          <p className="eyebrow">JWT BLOG DEMO</p>
          <h1>Stories, ideas, and little updates.</h1>
          <p className="intro-copy">Write something worth sharing, or take a moment to read what others have posted.</p>
        </section>

        <div className="content-layout">
          <aside className="sidebar">
            {user ? (
              <PostForm onCreated={loadPosts} />
            ) : (
              <AuthForm onLogin={setUser} />
            )}
            <p className="sidebar-note">Keep it kind. Keep it simple.</p>
          </aside>

          <section className="feed" aria-labelledby="feed-title">
            <div className="section-heading">
              <div>
                <p className="eyebrow">THE COMMUNITY</p>
                <h2 id="feed-title">Recent posts</h2>
              </div>
              <span className="post-count">{posts.length} {posts.length === 1 ? "post" : "posts"}</span>
            </div>

            {posts.length === 0 ? (
              <div className="empty-state">
                <span className="empty-mark" aria-hidden="true">✎</span>
                <h3>Nothing here just yet</h3>
                <p>When someone publishes a post, it will show up here.</p>
              </div>
            ) : (
              <div className="post-list">
                {posts.map((post) => (
                  <article className="post-card" key={post.id}>
                    <h3>{post.title}</h3>
                    <p className="post-content">{post.content}</p>
                    <div className="post-meta">
                      <span>By <strong>{post.author}</strong></span>
                      {post.createdAt && (
                        <time dateTime={post.createdAt}>
                          {new Date(post.createdAt).toLocaleString()}
                        </time>
                      )}
                    </div>
                  </article>
                ))}
              </div>
            )}
          </section>
        </div>
      </main>

      <footer className="site-footer">Made for sharing a few good words.</footer>
    </div>
  );
};

export default App;