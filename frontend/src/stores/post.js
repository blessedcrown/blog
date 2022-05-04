import { defineStore } from "pinia";

export const usePostStore = defineStore({
  id: "post",
  state: () => ({
    posts: []
  }),
  getters: {
    getPostById: (state) => {
      return (id) => state.posts.find(post => post.id === id);
    }
  },
  actions: {
    addPost(newPost) {
      this.posts = [...this.posts, newPost];
    },
    deletePost() {

    }
  },
});
