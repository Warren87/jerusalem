import {VerticalLayout} from "@hilla/react-components/VerticalLayout";
import {ConfirmDialog} from "@hilla/react-components/ConfirmDialog";
import NotificationRequest from "Frontend/generated/org/poglebiarka/admin/notifications/NotificationRequest";

interface NotificationConfirmProps {
    dialogOpened: boolean;
    onConfirm: (e: Event) => void;
    onReject: (e: Event) => void;
    previewRequest: NotificationRequest;
}

export default function NotificationConfirmDialog({dialogOpened, onConfirm, onReject, previewRequest}: Readonly<NotificationConfirmProps>) {

    return <ConfirmDialog
        header="Potwierdzenie wysłania"
        rejectButtonVisible
        confirmText="Wyślij"
        rejectText="Anuluj"
        opened={dialogOpened}
        onConfirm={onConfirm}
        onReject={onReject}
    >
        <VerticalLayout>
            <span>Tytuł: {previewRequest.mainTitle}</span>
            <span>Opis: {previewRequest.mainDescription}</span>
            <span>Podtytuł: {previewRequest.subTitle}</span>
            <span>Szerszy opis: {previewRequest.subDescription}</span>
        </VerticalLayout>

    </ConfirmDialog>
}