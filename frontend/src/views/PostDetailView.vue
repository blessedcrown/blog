<script setup>
import { useRoute } from "vue-router";
import TagChip from "../components/chip/TagChip.vue";
import { usePostStore } from "@/stores/post";
import BaseButton from "@/components/button/BaseButton.vue";
import CommentEditor from "@/components/editor/CommentEditor.vue";

const store = usePostStore();
const route = useRoute();

const getPost = store.getPostById;
const postId = route.params.id;
let post = getPost(postId);
if (post == undefined) {
  post = {
    title: "Default",
    author: "Default",
    date: "Default",
    tags: ["default"],
    content: "Default",
  };
}
</script>

<template>
  <div>
    <div>
      <img />
      <p class="post-description">
        Written by <span class="post-author">{{ post.author }}</span> on
        <span class="post-date">{{ post.date }}</span>
      </p>
      <h1>{{ post.title }}</h1>
      <TagChip v-for="tag in post.tags" :key="post.id" :tag="tag">{{
        tag
      }}</TagChip>
      <div class="content-container">
         <VueShowdown
            class="content"
            flavor="github"
            :markdown="post.content"
            :options="{ emoji: true }"/>
      </div>
      <div class="comment-container">
        <h2>Comments</h2>
        <CommentEditor class="comment-editor"></CommentEditor>
        <BaseButton>Comment</BaseButton>
      </div>
    </div>
  </div>
</template>

<style scoped>
.post-description {
  margin: 0px;
}
.post-author {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
.post-date {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
.content-container {
  margin: 50px 0px;
}
.comment-editor {
  margin-bottom: 20px;
}
.comment-container {
  margin-bottom: 50px;
}
</style>
