<script setup>
import NavTab from "@/components/navigation/NavTab.vue";
</script>

<template>
  <div class="navigation-wrapper">
    <nav class="navigation">
      <NavTab isLogo="true" link="/">Developer Blog</NavTab>
      <NavTab class="tab" link="/articles">📘 Articles</NavTab>
      <NavTab class="tab" link="/post/new">📄 Create Post</NavTab>
    </nav>
  </div>
</template>

<style scoped>
.navigation-wrapper {
  width: 100%;
  height: 60px;
  position: fixed;
  display: flex;
  justify-content: center;
  background-color: var(--navbar-color);
  border-bottom: 1px solid var(--border-color);
  z-index: 9999;
}
.navigation {
  width: 800px;
  display: flex;
  align-items: center;
}
.logo {
  font-size: var(--h5-font-size);
  font-weight: var(--h-font-weight);
  color: var(--font-color);
  text-decoration: none;
}
.tab {
  margin-right: 20px;
}
</style>
