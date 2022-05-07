import { createApp } from "vue";
import withUUID from "vue-uuid";
import { createPinia } from "pinia";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUpload } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import "@/assets/base.css";

import App from "./App.vue";
import router from "./router";

library.add(faUpload);

const app = withUUID(createApp(App));
app.use(createPinia());
app.use(router);
app.component("font-awesome-icon", FontAwesomeIcon);

app.mount("#app");
