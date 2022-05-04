<script setup>

</script>

<template>
  <div class="chip">
    <slot></slot>
  </div>
</template>

<style scope>
.chip {
  width: max-content;
  border-radius: 10px;
  border: 1px solid rgb(230,230,230);
  padding: 4px 10px;
  box-shadow: 0px 0px 1px rgb(230,230,230);
}
</style>