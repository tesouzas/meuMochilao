using API_Mochilao_SQL.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API_Mochilao_SQL.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ViagemController : ControllerBase
    {
        private readonly MochilaoDbContext _context;

        public ViagemController(MochilaoDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Viagem> GetViagens()
        {
            return _context.Viagens;
        }

        [HttpGet("{id}")]
        public IActionResult GetViagemPorId(int id)
        {
            Viagem viagem = _context.Viagens.SingleOrDefault(modelo => modelo.id_viagem == id);
            if (viagem == null)
            {
                return NotFound();
            }
            return new ObjectResult(viagem);
        }

        [HttpPost]
        public IActionResult CriarViagem(Viagem item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Viagens.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);
        }

        [HttpPut("{id}")]
        public IActionResult AtualizaViagem(int id, Viagem item)
        {
            if (id != item.id_viagem)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        public IActionResult DeletaViagem(int id)
        {
            var viagem = _context.Viagens.SingleOrDefault(m => m.id_viagem == id);

            if (viagem == null)
            {
                return BadRequest();
            }

            _context.Viagens.Remove(viagem);
            _context.SaveChanges();
            return Ok(viagem);
        }

    }


}

