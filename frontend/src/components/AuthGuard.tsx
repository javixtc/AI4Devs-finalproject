/**
 * AuthGuard
 *
 * Route guard for protected routes.
 * If the user has no active session, redirects to /login.
 * Otherwise renders the matched child route via <Outlet />.
 *
 * Usage in App.tsx:
 *   <Route element={<AuthGuard />}>
 *     <Route path="/" element={<MeditationBuilderPage />} />
 *     <Route path="/library" element={<MeditationLibraryPage />} />
 *   </Route>
 */

import { Navigate, Outlet, NavLink } from 'react-router-dom';
import { useAuthStore } from '@state/authStore';

export function AuthGuard() {
  const session = useAuthStore((state) => state.session);

  if (!session) {
    return <Navigate to="/login" replace />;
  }

  return (
    <div className="app">
      {/* Navigation — only shown when authenticated */}
      <nav className="app-nav">
        <ul>
          <li>
            <NavLink to="/" className={({ isActive }) => (isActive ? 'nav-active' : '')}>
              Crear Meditación
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/library"
              className={({ isActive }) => (isActive ? 'nav-active' : '')}
            >
              Biblioteca
            </NavLink>
          </li>
        </ul>
      </nav>

      {/* Authenticated child route */}
      <Outlet />
    </div>
  );
}
