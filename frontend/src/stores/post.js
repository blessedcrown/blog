import { defineStore } from "pinia";
import SampleMarkdown from "@/assets/markdown/sample.md";
import qs from "qs";
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
    async fetchPost(page, size) {
      await axios
        .get("/api/post", {
          params: { page: page, size: size },
        })
        .then((response) => {
          this.posts = [...response.data.content];
        });
    },
    initPost() {
      const posts = [
        {
          title: "Front End Tables: Sorting, Filtering, and Pagination",
          content: "SampleMarkdown",
        },
        {
          title: "An Introduction to MVC Pattern",
          content: "SampleMarkdown",
        },
        {
          title: "Creating a Schema-Based Form System",
          content: "SampleMarkdown",
        },
      ];

      posts.forEach((post) => this.addPost(post));
    },
    async addPost(newPost) {
      await axios
        .post("/api/post", qs.stringify(newPost), {
          headers: {
            Content: "application/x-www-form-urlencoded",
          },
        })
        .then((response) => {
          this.posts = [...this.posts, response.data];
        });
    },
    deletePost() {},
  },
});
