<script setup>
import { usePostStore } from "@/stores/post";
import { onMounted } from "vue";
import { uuid } from "vue-uuid";
import { RouterView } from "vue-router";
import SampleMarkdown from "@/assets/markdown/sample.md";
import TheNavigation from "@/components/navigation/TheNavigation.vue";

const store = usePostStore();

const initPost = [
  {
    id: uuid.v1(),
    image: "node.png",
    title: "Front End Tables: Sorting, Filtering, and Pagination",
    date: "May 02",
    author: "blessedcrown",
    tags: ["frontend"],
    content: `
    An h1 header

    Paragraphs are separated by a blank line.

    2nd paragraph. *Italic*, **bold**. lists
    look like:

    * this one
    * that one
    * the other one

    Note that --- not considering the asterisk --- the actual text
    content starts at 4-columns in.

    > Block quotes are
    > written like so.
    >
    > They can span multiple paragraphs,
    > if you like.

    Use 3 dashes for an em-dash. Use 2 dashes for ranges (ex., "it's all
    in chapters 12--14"). Three dots ... will be converted to an ellipsis.
    Unicode is supported. ☺`,
  },
  {
    id: uuid.v1(),
    image: "spring.png",
    title: "An Introduction to MVC Pattern",
    date: "April 02",
    author: "blessedcrown",
    tags: ["backend"],
    content: `
    An h1 header

    Paragraphs are separated by a blank line.

    2nd paragraph. *Italic*, **bold**. lists
    look like:

    * this one
    * that one
    * the other one

    Note that --- not considering the asterisk --- the actual text
    content starts at 4-columns in.

    > Block quotes are
    > written like so.
    >
    > They can span multiple paragraphs,
    > if you like.

    Use 3 dashes for an em-dash. Use 2 dashes for ranges (ex., "it's all
    in chapters 12--14"). Three dots ... will be converted to an ellipsis.
    Unicode is supported. ☺`,
  },
  {
    id: uuid.v1(),
    image: "vuejs.png",
    title: "Creating a Schema-Based Form System",
    date: "March 12",
    author: "blessedcrown",
    tags: ["frontend"],
    content: `
    An h1 header

    Paragraphs are separated by a blank line.

    2nd paragraph. *Italic*, **bold**. lists
    look like:

    * this one
    * that one
    * the other one

    Note that --- not considering the asterisk --- the actual text
    content starts at 4-columns in.

    > Block quotes are
    > written like so.
    >
    > They can span multiple paragraphs,
    > if you like.

    Use 3 dashes for an em-dash. Use 2 dashes for ranges (ex., "it's all
    in chapters 12--14"). Three dots ... will be converted to an ellipsis.
    Unicode is supported. ☺`,
  },
];

console.log(initPost[0].content);

onMounted(() => {
  store.fetchPost(0, 10);
  initPost.forEach((post) => {
    store.addPost(post);
  });
});
</script>

<template>
  <div class="root">
    <TheNavigation />

    <main class="main">
      <content class="content">
        <RouterView class="content" />
      </content>
    </main>
  </div>
</template>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
  position: relative;
}
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
  padding: 40px;
  margin-top: 50px;
}
.content {
  width: 800px;
}
</style>
