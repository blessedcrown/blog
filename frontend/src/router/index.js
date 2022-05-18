import { createRouter, createWebHistory } from "vue-router";
import DashboardView from "../views/DashboardView.vue";
import PostDetailView from "../views/PostDetailView.vue";
import PostNewView from "../views/PostNewView.vue";
import PostFilterView from "../views/PostFilterView.vue";
import TagFilterView from "../views/TagFilterView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "dashboard",
      component: DashboardView,
    },
    {
      path: "/post/new",
      name: "new post",
      component: PostNewView,
    },
    {
      path: "/posts/:id",
      name: "posts",
      component: PostDetailView,
    },
    {
      path: "/tags/:tag",
      name: "tags",
      component: TagFilterView,
    },
    {
      path: "/articles",
      name: "articles",
      component: PostFilterView,
    },
  ],
});

export default router;
