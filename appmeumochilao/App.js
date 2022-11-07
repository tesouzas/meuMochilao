import React,{Component} from 'react'
import {SafeAreaView, Text, StyleSheet, FlatList} from 'react-native'
import api from './src/Services/Api';
import viagem from './src/Pages/Viagem'

export default class App extends Component{

  constructor(props){
    super(props);
    this.state = {
      viagem: []
    }
  }

  async componentDidMount(){
    const response = await api.get('/viagem');
    this.setState({
      viagem: response.data
    })
  }

  render(){
    return{
      <SafeAreaView style={styles.container}>
        <FlatList
        data={this.state.viagem}
        keyExtractor={item => item.id_viagem}
        renderItem={({item}) => <Viagem data={item} />}
        />
      </SafeAreaView>

    }
  }
}

const styles = StyleSheet.create({
  container:{
    flex:1,
    backgroundColor: 'orange'
  }
});
