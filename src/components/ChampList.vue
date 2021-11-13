<template>
<div>
  <h1>League of Legends Champions</h1>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Title</th>
          <th>Tags</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="champ in champions" :key="champ.id" @click="$emit('open-modal', champ.id)">
            <td>{{champ.id}}</td>
            <td>{{champ.title}}</td>
            <td>{{champ.tags}}</td>
        </tr>
      </tbody>
    </table>
</div>

</template> 

<script>

export default {
  name: 'ChampList',

  created: function(){
      this.fetchData()
  },

  data: function(){
    return {
      champions: [],
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
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 table{
   background-color: whitesmoke;
   width: 75vw;
   table-layout: fixed;
   margin-left: auto;
   margin-right: auto;
   border-radius: 20px;
 }

 th{
   font-size: 20px;
   height: 5vh;
 }

 td{
   height: 2.5vh;
 }
</style>
