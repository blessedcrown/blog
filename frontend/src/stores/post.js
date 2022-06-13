import { defineStore } from "pinia";
import qs from "qs";
import axios from "@/axios";

export const usePostStore = defineStore({
  id: "post",
  state: () => ({
    posts: [],
  }),
  getters: {
    getPostById: (state) => {
      return (id) => state.posts.find((post) => post.id == id);
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
          title: "Guide to Using Markdown Language",
          content: `
            Markdown is a lightweight markup language that you can use to add formatting elements to plaintext text documents. 
            Created by John Gruber in 2004, Markdown is now one of the world’s most popular markup languages.
          `,
        }
      ];

      posts.forEach((post) => this.publishPost(post));
    },
    /**
     * Save the post in pinia store
     * @param {*} post 
     */
    savePost(post) {
      this.posts = [...this.posts, post];
    },
    /**
     * Make API call to backend and save the post to DB
     * @param {*} newPost 
     */
    async publishPost(newPost) {
      await axios
        .post("/api/post", qs.stringify(newPost), {
          headers: {
            Content: "application/x-www-form-urlencoded",
          },
        })
        .then((response) => {
          this.savePost(response.data);
        });
    },
    deletePost() {},
  },
});
