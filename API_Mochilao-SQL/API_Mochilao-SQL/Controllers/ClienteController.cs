using API_Mochilao_SQL.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API_Mochilao_SQL.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ClienteController : ControllerBase
    {
        private readonly MochilaoDbContext _context;

        public ClienteController(MochilaoDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Cliente> GetClientes()
        {
            return _context.Clientes;
        }

        [HttpGet("{id}")]
        public IActionResult GetClientePorId(int id)
        {
            Cliente cliente = _context.Clientes.SingleOrDefault(modelo => modelo.id_cliente == id);
            if (cliente == null)
            {
                return NotFound();
            }
            return new ObjectResult(cliente);
        }

        [HttpPost]
        public IActionResult CriarCliente(Cliente item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Clientes.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);
        }

        [HttpPut("{id}")]
        public IActionResult AtualizaCliente(int id, Cliente item)
        {
            if (id != item.id_cliente)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        public IActionResult DeletaCliente(int id)
        {
            var cliente = _context.Clientes.SingleOrDefault(m => m.id_cliente == id);

            if (cliente == null)
            {
                return BadRequest();
            }

            _context.Clientes.Remove(cliente);
            _context.SaveChanges();
            return Ok(cliente);
        }

    }


}
