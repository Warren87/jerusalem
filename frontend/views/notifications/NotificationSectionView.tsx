import {Tab} from "@hilla/react-components/Tab";
import {Tabs} from "@hilla/react-components/Tabs";
import {TabSheet} from "@hilla/react-components/TabSheet";
import {lazy} from 'react';
import NotificationsView from "Frontend/views/notifications/NotificationsView";

const NotificationsHistoryView = lazy(async () => import('Frontend/views/notifications/NotificationsHistoryView.js'));

export default function NotificationSectionView() {
    return (
        <TabSheet>
            <Tabs slot="tabs">
                <Tab id="send-notifications-tab">Wysyłanie</Tab>
                <Tab id="send-history-tab">Historia wysłanych</Tab>
            </Tabs>

            <div {...{ tab: 'send-notifications-tab' }}><NotificationsView /></div>
            <div {...{ tab: 'send-history-tab' }}><NotificationsHistoryView /></div>
        </TabSheet>
    );
}