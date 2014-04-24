namespace IrenaWeb.Services
{
    using System.Web;

    using IrenaWeb.Models;

    public interface IQrCodeService
    {
        IHtmlString GenerateRelayQrCode(HistoriaClinica medicalHistory, int height = 250, int width = 250, int margin = 0);
    }
}
