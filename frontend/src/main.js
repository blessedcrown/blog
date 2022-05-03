import { createApp } from "vue";
import withUUID from "vue-uuid";
import { createPinia } from "pinia";
import "@/assets/base.css";

import App from "./App.vue";
import router from "./router";

const app = withUUID(createApp(App));

app.use(createPinia());
app.use(router);

app.mount("#app");
