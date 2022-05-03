<script setup>
import UserAvatar from "@/components/avatar/UserAvatar.vue";
</script>

<template>
  <header class="header">
    <UserAvatar></UserAvatar>
  </header>
</template>

<style scope>
.header {
  height: 100px;
  width: 100%;
  display: flex;
  justify-content: flex-end;
}
</style>
