import react,{Component} from 'react';
import {View, Text, StyleSheet, TouchableOpacity} from 'react-native';

export default class viagem extends Component {
    render(){
        return{
            <View>
                <Text style={styles.destino}>{this.props.data.destino_viagem}</Text>
                <TouchableOpacity onPress={consulta}>
                <Text>Consultar Viagem</Text>
                </TouchableOpacity>
            </View>
        }
    }
}

const styles = StyleSheet.create({
    container:{

    },
    destino_viagem: {
        color: 'white',
        fontSize: 18,
        fontWeight: 'bold'
    }
});
