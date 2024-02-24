import {FormLayout} from "@hilla/react-components/FormLayout";
import {TextField} from "@hilla/react-components/TextField.js";
import {TextArea} from "@hilla/react-components/TextArea";
import {useForm} from "@hilla/react-form";
import NotificationRequestModel from "Frontend/generated/org/poglebiarka/admin/notifications/NotificationRequestModel";
import {Button} from "@hilla/react-components/Button.js";
import {useState} from "react";
import NotificationConfirmDialog from "Frontend/views/notifications/NotificationConfirmDialog";
import NotificationRequest from "Frontend/generated/org/poglebiarka/admin/notifications/NotificationRequest";
import Link from "Frontend/generated/org/poglebiarka/admin/notifications/Link";
import {NotificationEndpoint} from "Frontend/generated/endpoints";
import {Notification} from "@hilla/react-components/Notification";


export default function NotificationsView() {
    const [dialogOpened, setDialogOpened] = useState(false);

    function openDialog() {
        setDialogOpened(true);
    }

    function closeDialog(){
        setDialogOpened(false);
    }


    async function onSubmit(request: NotificationRequest) {
        const links: Link[] = []
        await NotificationEndpoint.notifyAll({...request, links})
        closeDialog()
        Notification.show(`Notification [${request.mainTitle}] sent`);
    }

    const {field, model, submit, invalid} = useForm(NotificationRequestModel, {onSubmit})

    return (<section className="flex p-m gap-m items-end">
                <FormLayout>
                    <TextField label="Tytuł" {...field(model.mainTitle)}/>
                    <TextArea label="Opis" {...field(model.mainDescription)}/>
                    <TextField label="Podtytuł" {...field(model.subTitle)}/>
                    <TextArea label="Szerszy opis" {...field(model.subDescription)}/>
                </FormLayout>
                <Button onClick={openDialog} disabled={invalid}>Wyślij</Button>

                <NotificationConfirmDialog dialogOpened={dialogOpened}
                                           onConfirm={submit}
                                           onReject={closeDialog}
                                           previewRequest={model.valueOf()}/>

                <span>TODO Create dynamically Button Links Here</span>
            </section>
    );
}
