using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace API_Mochilao_SQL.Models
{

    [Table("Viagem")]
    public class Viagem
    {
        [Key]
        public int id_viagem { get; set; }

        [Required(ErrorMessage = "Digite seu destino:")]
        [StringLength(50)]
        public string destino_viagem { get; set; }

        [Required(ErrorMessage = "Informe seu pacote:")]
        [StringLength(50)]
        public string pacote_viagem { get; set; }

        [Required(ErrorMessage = "Informe seu valor:")]
        public decimal valor_pacote_viagem { get; set; }

    }

}
