using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace API_Mochilao_SQL.Models
{

    [Table("Cliente")]
    public class Cliente
    {
        [Key]
        public int id_cliente { get; set; }

        [Required(ErrorMessage = "Digite seu nome:")]
        [StringLength(50)]
        public string nome_cliente { get; set; }

        [Required(ErrorMessage = "Informe seu CPF:")]
        public string cpf_cliente { get; set; }

        [Required(ErrorMessage = "Informe sua cidade:")]
        [StringLength(50)]
        public string cidade_cliente { get; set; }
    }

}
