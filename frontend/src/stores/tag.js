import { defineStore } from "pinia";

export const useTagStore = defineStore({
  id: "tag",
  state: () => ({
    tags: [],
  }),
  getters: {
    getPostById: (state) => {
      return (id) => state.tags.find((tag) => tag.id === id);
    },
  },
  actions: {
    addPost(newTag) {
      this.tags = [...this.tags, newTag];
    },
    deletePost() {},
  },
});
