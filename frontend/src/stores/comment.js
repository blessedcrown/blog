import { defineStore } from "pinia";
import axios from "@/axios";

export const useCommentStore = defineStore({
  id: "comment",
  state: () => ({
    comments: [],
  }),
  getters: {
    getCommentByPostId: (state) => {
      return (id) => state.comments.filter((comment) => comment.postId === id);
    },
  },
  actions: {
    async fetchComment(page, size) {
      await axios
        .get("/api/comment", {
          params: { page: page, size: size },
        })
        .then((response) => {
          this.comments = [...response.data.content];
        });
    },
    initComment() {
      const comments = [
        {
          id: 0,
          reply: "Very useful article. Thanks!",
        },
        {
          id: 1,
          reply: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sagittis purus vel felis rutrum rutrum. Vivamus accumsan ac velit et consequat. Aliquam feugiat velit id elit facilisis scelerisque. ",
        },
      ];

      comments.forEach((comment) => this.addComment(comment));
    },
    async addComment(newComment) {
        this.comments = [...this.comments, newComment];
    //   await axios
    //     .post("/api/post", qs.stringify(newPost), {
    //       headers: {
    //         Content: "application/x-www-form-urlencoded",
    //       },
    //     })
    //     .then((response) => {
    //       this.posts = [...this.posts, response.data];
    //     });
    },
    deleteComment() {},
  },
});
