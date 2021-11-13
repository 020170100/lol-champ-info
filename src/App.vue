<template>
  <champ-list @open-modal="showDetail"></champ-list>
  <detail-modal :champId = "champId" v-show="displayModal" @close-modal="displayModal = false"></detail-modal>
</template>

<script>
import ChampList from './components/ChampList.vue'
import DetailModal from './components/DetailModal.vue'

export default {
  name: 'App',
  components: {
    ChampList,
    DetailModal,
  },

  data:function(){
      return {
        displayModal: false,
        champId: "",
      };
  },

  methods:{

    showDetail(id){
        this.displayModal = true
        this.champId = id
        console.log("i was here!", this.champId, id)
    }

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
