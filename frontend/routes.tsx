import { protectRoutes } from '@hilla/react-auth';
import HelloWorldView from 'Frontend/views/helloworld/HelloWorldView.js';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, RouteObject } from 'react-router-dom';
import OAuth2LoginView from "Frontend/views/login/OAuth2LoginView";

const AboutView = lazy(async () => import('Frontend/views/about/AboutView.js'));

export const routes = protectRoutes([
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/', element: <HelloWorldView />, handle: { title: 'Hello World', requiresLogin: true } },
      { path: '/about', element: <AboutView />, handle: { title: 'About', requiresLogin: true } },
    ],
  },
  { path: '/login', element: <OAuth2LoginView /> },
]) as RouteObject[];

export default createBrowserRouter(routes);
