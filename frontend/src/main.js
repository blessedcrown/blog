import { createApp } from "vue";
import withUUID from "vue-uuid";
import { createPinia } from "pinia";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUpload } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import "@/assets/base.css";
import App from "./App.vue";
import router from "./router";
import { VueShowdown } from "vue-showdown";

const app = withUUID(createApp(App));
app.use(createPinia());
app.use(router);
app.component("VueShowdown", VueShowdown);

// Font Awesome
library.add(faUpload);
app.component("font-awesome-icon", FontAwesomeIcon);

app.mount("#app");
