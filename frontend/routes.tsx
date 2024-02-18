import {protectRoutes} from '@hilla/react-auth';
import MainLayout from 'Frontend/views/MainLayout.js';
import {createBrowserRouter, RouteObject} from 'react-router-dom';
import OAuth2LoginView from "Frontend/views/login/OAuth2LoginView";
import NotificationSectionView from "Frontend/views/notifications/NotificationSectionView";


export const routes = protectRoutes([
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/notifications', element: <NotificationSectionView />, handle: { title: 'Powiadomienia', requiresLogin: true } },
      { path: '/', element: <NotificationSectionView />, handle: { title: 'Powiadomienia', requiresLogin: true } },
    ],
  },
  { path: '/login', element: <OAuth2LoginView /> },
]) as RouteObject[];

export default createBrowserRouter(routes);
