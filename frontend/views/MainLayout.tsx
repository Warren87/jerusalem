import {AppLayout} from '@hilla/react-components/AppLayout.js';
import {Avatar} from '@hilla/react-components/Avatar.js';
import {Button} from '@hilla/react-components/Button.js';
import {DrawerToggle} from '@hilla/react-components/DrawerToggle.js';
import Placeholder from 'Frontend/components/placeholder/Placeholder.js';
import {useAuth} from 'Frontend/util/auth.js';
import {useRouteMetadata} from 'Frontend/util/routing.js';
import {Suspense, useEffect} from 'react';
import {NavLink, Outlet} from 'react-router-dom';
import {Tabs} from "@hilla/react-components/Tabs";
import {Tab} from "@hilla/react-components/Tab";
import {Icon} from "@hilla/react-components/Icon";

const navLinkClasses = ({isActive}: any) => {
    return `block rounded-m p-s ${isActive ? 'bg-primary-10 text-primary' : 'text-body'}`;
};

export default function MainLayout() {
    const currentTitle = useRouteMetadata()?.title ?? 'Jerusalem - Admin Aplikacji';
    const {state, logout} = useAuth();

    useEffect(() => {
        document.title = currentTitle;
    }, [currentTitle]);
    return (


        <AppLayout primarySection="drawer">
            <div slot="drawer" className="flex flex-col justify-between h-full p-m">
                <header className="flex flex-col gap-m">
                    <h1 className="text-l m-0">Jerusalem App</h1>
                    <nav>
                        {state.user ? (
                            <NavLink className={navLinkClasses} to="/notifications">
                                <Icon icon="vaadin:bell" />
                                Powiadomienia
                            </NavLink>
                        ) : null}
                    </nav>
                </header>
                <footer className="flex flex-col gap-s">
                    {state.user ? (
                        <>
                            <div className="flex items-center gap-s">
                                <Avatar theme="xsmall" name={state.user.name}/>
                                {state.user.name}
                            </div>
                            <div className="flex items-center gap-s">
                                {state.user.email}
                            </div>
                            <Button onClick={async () => logout()}>Wyloguj</Button>
                        </>
                    ) : (
                        <a href="/login">Zaloguj</a>
                    )}
                </footer>
            </div>

            <DrawerToggle slot="navbar" aria-label="Menu toggle"></DrawerToggle>

            <h2 slot="navbar" className="text-l m-0">
                {currentTitle}
            </h2>

            <Suspense fallback={<Placeholder/>}>
                <Outlet/>
            </Suspense>
        </AppLayout>

    );
}
