/**
 * AppHeader
 *
 * Application header shown to authenticated users.
 * Displays the user's name, profile photo and a "Cerrar sesión" button.
 *
 * When the user clicks "Cerrar sesión":
 *   1. authStore.logout() is called (clears local session + notifies backend — C4)
 *   2. The user is redirected to /login
 *
 * Note: This component only renders when a session is active (AuthGuard ensures this).
 */

import { useNavigate } from 'react-router-dom';
import { useAuthStore } from '@state/authStore';

export function AppHeader() {
  const session = useAuthStore((state) => state.session);
  const logout = useAuthStore((state) => state.logout);
  const navigate = useNavigate();

  if (!session) return null;

  const handleLogout = async () => {
    await logout();
    navigate('/login', { replace: true });
  };

  return (
    <header className="app-header">
      <div className="app-header__user">
        {session.foto && (
          <img
            className="app-header__avatar"
            src={session.foto}
            alt={`Foto de perfil de ${session.nombre}`}
          />
        )}
        <span className="app-header__name" data-testid="header-user-name">
          {session.nombre}
        </span>
      </div>

      <button
        className="app-header__logout"
        onClick={handleLogout}
        data-testid="header-logout-button"
      >
        Cerrar sesión
      </button>
    </header>
  );
}
