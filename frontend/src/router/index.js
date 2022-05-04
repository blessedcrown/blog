import { createRouter, createWebHistory } from "vue-router";
import DashboardView from "../views/DashboardView.vue";
import PostDetailView from "../views/PostDetailView.vue";
import PostFilterView from "../views/PostFilterView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "dashboard",
      component: DashboardView,
    },
    {
      path: "/posts/:id",
      name: "posts",
      component: PostDetailView,
    },
    {
      path: "/tags/:tag",
      name: "tags",
      component: PostFilterView,
    },
  ],
});

export default router;
