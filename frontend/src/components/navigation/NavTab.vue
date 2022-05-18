<script setup>
defineProps({
  isLogo: Boolean,
  link: String,
});
</script>

<template>
  <div class="nav-tab">
    <router-link
      :class="{ 'nav-link--logo': isLogo, 'nav-link': !isLogo }"
      :to="link"
    >
      <slot></slot>
    </router-link>
  </div>
</template>

<style scoped>
.nav-link--logo {
  padding: 3px 8px;
  border-radius: 5px;
  margin-right: 50px;

  font-size: var(--h5-font-size);
  font-weight: var(--h-font-weight);
  color: var(--font-color);
  text-decoration: none;
}
.nav-link {
  padding: 3px 8px;
  border-radius: 5px;

  font-size: var(--h5-font-size);
  font-weight: var(--p-font-weight);
  color: var(--font-color);
  text-decoration: none;
}
.nav-link--logo:hover {
  background-color: var(--navbar-color-hover);
}
.nav-link:hover {
  background-color: var(--navbar-color-hover);
}
</style>
