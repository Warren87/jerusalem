import {configureAuth} from '@hilla/react-auth';
import {auth} from "Frontend/generated/endpoints";

const authModule = configureAuth(auth.authenticatedUser);

export const useAuth = authModule.useAuth;
export const AuthProvider = authModule.AuthProvider;
