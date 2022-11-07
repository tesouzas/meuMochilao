using API_Mochilao_SQL.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API_Mochilao_SQL.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CadastroController : ControllerBase
    {
        private readonly MochilaoDbContext _context;

        public CadastroController(MochilaoDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Cadastro> GetCadastros()
        {
            return _context.Cadastros;
        }

        [HttpGet("{id}")]
        public IActionResult GetCadastroPorId(int id)
        {
            Cadastro cadastro = _context.Cadastros.SingleOrDefault(modelo => modelo.id == id);
            if (cadastro == null)
            {
                return NotFound();
            }
            return new ObjectResult(cadastro);
        }

        [HttpPost]
        public IActionResult CriarCadastro(Cadastro item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Cadastros.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);
        }

        [HttpPut("{id}")]
        public IActionResult AtualizaCadastro(int id, Cadastro item)
        {
            if (id != item.id)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        public IActionResult DeletaCadastro(int id)
        {
            var cadastro = _context.Cadastros.SingleOrDefault(m => m.id == id);

            if (cadastro == null)
            {
                return BadRequest();
            }

            _context.Cadastros.Remove(cadastro);
            _context.SaveChanges();
            return Ok(cadastro);
        }

    }


}

