<template>
  <router-view/>
  <champ-list @open-modal="showDetail"></champ-list>
  
</template>

<script>
export default {
  name: 'App',
  components: {

  },

  data:function(){
      return {
      
      };
  },


}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
