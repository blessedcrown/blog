import { defineStore } from "pinia";
import SampleMarkdown from "@/assets/markdown/sample.md";
import axios from "@/axios";

export const usePostStore = defineStore({
  id: "post",
  state: () => ({
    posts: [],
  }),
  getters: {
    getPostById: (state) => {
      return (id) => state.posts.find((post) => post.id === id);
    },
  },
  actions: {
    initPost() {
      const posts = [{
        'title': 'Front End Tables: Sorting, Filtering, and Pagination',
        'content': SampleMarkdown,
      },{
        'title': 'An Introduction to MVC Pattern',
        'content': SampleMarkdown,
      },{
        'title': 'Creating a Schema-Based Form System',
        'content': SampleMarkdown,
      }]

      posts.forEach(post => this.addPost(post));
    },
    async addPost(newPost) {
      await axios.post("/api/post", newPost).then((response) => {
        console.log(response);
      });
      this.posts = [...this.posts, newPost];
    },
    deletePost() {},
  },
});
