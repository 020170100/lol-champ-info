<template>
<div>
    <detail-modal :detailInfo = "champDetails" v-show="displayModal" @close-modal="displayModal = false"></detail-modal>
    <table>
      <caption>League of Legends Champions</caption>
      <tbody>
        <tr class="champ-rows" v-for="champ in champions" :key="champ.name" @click="showDetail(champ.id)">
            <td class="left-td">
              <img :src="champ.img_url">
            </td>
            <td class="right-td">{{champ.name}}</td>
        </tr>
      </tbody>
    </table>
</div>

</template> 

<script>

import DetailModal from "./DetailModal.vue"
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
      champId: "",
      champDetails: [],
    };
  },


  methods: {
    async fetchData(){
      try{
        let response = await fetch("http://localhost:8080/champ")
        let json = await response.json()
        console.log(json)
        this.champions = json    
      }catch(e){
        console.log(e)
      }
    },

    showDetail(id){
        this.displayModal = true
        this.champId = id
        this.getDetailInfo(id)
        console.log("i was here!", this.champId, id)        
    },
    
    async getDetailInfo(id){
            if(id != this.champDetails.id){
                try{
                    let response = await fetch("http://localhost:8080/champ/"+id)
                    let json = await response.json()
                    console.log(json)
                    this.champDetails = json
                    console.log(this.champDetails.name)
                }catch(e){
                    console.log(e)
                }   
            }
        }

  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 table{
   background-color: whitesmoke;
   width: 50vw;
   margin-left: auto;
   margin-right: auto;
   border-collapse: collapse;
 }

 .champ-rows{
    border-bottom: 1px solid grey;
 }

 table tr:hover {
   background-color: rgb(221, 221, 221);
 }

 td{
   height: 2vh;
   font-size: 25px;
   font-weight: bold;
   padding-top: 5px;
 }

 .left-td{
   text-align: center ;
 }

 .right-td{
   text-align: left;
 }

 caption{
   font-size: 30px;
   font-weight: bold;
   background-color: lightskyblue;
   padding-top: 20px;
   padding-bottom: 20px;
   border-top-left-radius: 20px;
   border-top-right-radius: 20px
 }
</style>
