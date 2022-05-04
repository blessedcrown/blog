<script setup>
import NavTab from "@/components/navigation/NavTab.vue";
</script>

<template>
  <nav class="navigation">
    <h3 class="title">Developer<br />Blog.</h3>

    <section class="tab-container">
      <NavTab link="/">Articles</NavTab>
    </section>
  </nav>
</template>

<style scoped>
.navigation {
  width: 340px;
  height: 100%;
  background-color: var(--background-mute);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  position: fixed;
}
.title {
  color: white;
  margin-bottom: 70px;
}
.tab-container {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  margin-bottom: 200px;
}
</style>
