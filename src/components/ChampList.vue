<template>
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
      <tr v-for="champ in champions" :key="champ.id">
          <td>{{champ.id}}</td>
          <td>{{champ.title}}</td>
          <td>{{champ.tags}}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'ChampList',

  created: function(){
      this.fetchData()
  },

  data: function(){
    return {
      champions: []
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
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
