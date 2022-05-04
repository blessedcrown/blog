<script setup>
import { useRoute } from 'vue-router';
import CategoryChip from "../components/chip/CategoryChip.vue";
import { usePostStore } from "@/stores/post";

const store = usePostStore();
const route = useRoute();

const getPost = store.getPostById;
const postId = route.params.id;
const post = getPost(postId);
</script>

<template>
  <div>
    <div>
      <img />
      <p>Written by <span class="post-author">{{post.author}}</span> on <span class="post-date">{{post.date}}</span></p>
      <h3>{{post.title}}</h3>
      <CategoryChip>{{post.category}}</CategoryChip>
    </div>
  </div>
</template>

<style scoped>
.post-author {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
.post-date {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
</style>