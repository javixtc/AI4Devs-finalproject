/**
 * LoginPage
 *
 * Public page that renders the "Iniciar sesión con Google" button.
 * Accessible at /login — outside the AuthGuard.
 *
 * Behavior:
 * - If the user already has an active session → redirects to / (AuthGuard will handle routing).
 * - On Google success → calls authStore.loginWithGoogle(credential) → stores session → Navigate to /.
 * - On Google error / cancellation (C5) → stays on /login, does not throw.
 *
 * Note: GoogleOAuthProvider must wrap this component (set up in App.tsx).
 */

import { useEffect } from 'react';
import { useNavigate, Navigate } from 'react-router-dom';
import { GoogleLogin, type CredentialResponse } from '@react-oauth/google';
import { useAuthStore } from '@state/authStore';

export function LoginPage() {
  const session = useAuthStore((state) => state.session);
  const isLoading = useAuthStore((state) => state.isLoading);
  const error = useAuthStore((state) => state.error);
  const loginWithGoogle = useAuthStore((state) => state.loginWithGoogle);
  const resetError = useAuthStore((state) => state.resetError);
  const navigate = useNavigate();

  // Clear any stale error when the page mounts
  useEffect(() => {
    resetError();
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  // Already authenticated → go to the builder
  if (session) {
    return <Navigate to="/" replace />;
  }

  const handleSuccess = async (credentialResponse: CredentialResponse) => {
    if (!credentialResponse.credential) return;
    try {
      await loginWithGoogle(credentialResponse.credential);
      navigate('/', { replace: true });
    } catch {
      // error is already set in authStore — rendered below
    }
  };

  const handleError = () => {
    // C5: user cancelled the Google flow — stay on /login without error
  };

  return (
    <div className="login-page">
      <div className="login-card">
        <h1>Meditation Builder</h1>
        <p className="login-subtitle">
          Accede con tu cuenta de Google para crear y gestionar tus meditaciones.
        </p>

        {error && (
          <p className="login-error" role="alert">
            {error}
          </p>
        )}

        <div className="login-button-wrapper">
          {isLoading ? (
            <p className="login-loading">Iniciando sesión…</p>
          ) : (
            <GoogleLogin
              onSuccess={handleSuccess}
              onError={handleError}
              useOneTap={false}
              context="signin"
            />
          )}
        </div>
      </div>
    </div>
  );
}
