import { defineStore } from "pinia";

export const useTagStore = defineStore({
  id: "tag",
  state: () => ({
    tags: [],
  }),
  getters: {
    getTagById: (state) => {
      return (id) => state.tags.find((tag) => tag.id === id);
    },
  },
  actions: {
    saveTag(newTag) {
      this.tags = [...this.tags, newTag];
    },
    deletePost() {},
  },
});
