<template>
<div>
  <p>League of Legends Champion Table</p>
    <table>
      <caption>Champions</caption>
      <thead>
        <tr>
          <th>Name</th>
          <th>Title</th>
          <th>Tags</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="champ in champions"  @click="showDetail(champ.id)" :key="champ.id">
            <td>{{champ.id}}</td>
            <td>{{champ.title}}</td>
            <td>{{champ.tags}}</td>
        </tr>
      </tbody>
    </table>
</div>
<DetailModal v-show="displayModal" @close-modal="displayModal = false"></DetailModal>
</template>

  

<script>
import DetailModal from './DetailModal.vue';

export default {
  name: 'ChampList',
  components: {
    DetailModal
  },

  created: function(){
      this.fetchData()
  },

  data: function(){
    return {
      champions: [],
      displayModal: false,
    };
  },

  methods: {
    async fetchData(){
      try{
        var response = await fetch("http://localhost:3000/data")
        var json = await response.json()
        console.log(json)
        this.champions = json     
      }catch(e){
        console.log(e)
      }
      
    },
    
    showDetail(champId){
      this.displayModal = true
      console.log("clicked: ", champId)
    },
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
