<template>
  <champ-list @open-modal="showDetail"></champ-list>
  <detail-modal :detailInfo = "champDetails" v-show="displayModal" @close-modal="displayModal = false"></detail-modal>
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
        champDetails: [],
      };
  },

  methods:{

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
