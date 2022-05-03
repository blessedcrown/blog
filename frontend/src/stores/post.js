import { defineStore } from "pinia";

export const usePostStore = defineStore({
  id: "post",
  state: () => ({
    posts: []
  }),
  getters: {
    getPost: (state) => state.posts,
  },
  actions: {
    addPost(newPost) {
      this.posts = [...this.posts, newPost];
    },
    deletePost() {

    }
  },
});
